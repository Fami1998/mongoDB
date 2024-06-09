<template>
  <div>
    <ProductDetail :productId="$route.params.id" />
    <Comment :productId="$route.params.id" />
  </div>
</template>

<script>
import ProductDetail from "../components/ProductDetail.vue";
import Comment from "../components/Comment.vue";

export default {
  name: "shopping-product",
  components: {
    ProductDetail,
    Comment,
  },
};
</script>

<style scoped>
/* 样式 */
</style>
