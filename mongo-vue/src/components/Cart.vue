<template>
  <div>
    <h2>Your Cart</h2>
    <div v-for="product in cartProducts" :key="product.id">
      <h3>{{ product.name }}</h3>
      <p>{{ product.price }}</p>
    </div>
    <button @click="checkout">Checkout</button>
  </div>
</template>

<script>
export default {
  name: "shopping-cart",
  data() {
    return {
      cartProducts: [],
    };
  },
  created() {
    // Fetch cart products from the API
    fetch("http://localhost:8080/api/carts/1") // assuming user ID is 1
        .then((response) => response.json())
        .then((data) => {
          this.cartProducts = data.productIds.map((productId) => {
            // Fetch product details for each product ID in the cart
            return fetch(`http://localhost:8080/api/products/${productId}`)
                .then((response) => response.json())
                .then((product) => product);
          });
        });
  },
  methods: {
    checkout() {
      // Checkout logic
    },
  },
};
</script>

<style scoped>
/* 样式 */
</style>
