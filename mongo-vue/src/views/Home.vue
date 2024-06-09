<template>
  <div>
    <h1>Welcome to Our Store</h1>
    <ProductList />
  </div>
</template>

<script>
import ProductList from "../components/ProductList.vue";

export default {
  name: "shopping-home",
  components: {
    ProductList,
  },
};
</script>

<style scoped>
/* 样式 */
</style>
