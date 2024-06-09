<template>
  <div>
    <h2>{{ product.name }}</h2>
    <p>{{ product.description }}</p>
    <p>{{ product.price }}</p>
    <button @click="addToCart">Add to Cart</button>
  </div>
</template>

<script>
export default {
  name: "shopping-productDetail",
  props: {
    productId: String,
  },
  data() {
    return {
      product: {},
    };
  },
  created() {
    // Fetch product details from the API
    fetch(`http://localhost:8080/api/products/${this.productId}`)
        .then((response) => response.json())
        .then((data) => {
          this.product = data;
        });
  },
  methods: {
    addToCart() {
      // Add product to cart logic
    },
  },
};
</script>

<style scoped>
/* 样式 */
</style>
