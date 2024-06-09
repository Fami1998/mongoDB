<template>
  <div>
    <h2>Products</h2>
    <div v-for="product in products" :key="product.id">
      <router-link :to="{ name: 'product', params: { id: product.id } }">
        <h3>{{ product.name }}</h3>
      </router-link>
      <p>{{ product.description }}</p>
      <p>{{ product.price }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "shopping-productList",
  data() {
    return {
      products: [],
    };
  },
  created() {
    // 使用 Axios 获取产品列表
    axios.get("http://localhost:8080/api/products")
        .then((response) => {
          this.products = response.data;
        })
        .catch((error) => {
          console.error("There was an error fetching the products!", error);
        });
  },
};
</script>

<style scoped>
/* 样式 */
</style>
