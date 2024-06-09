<template>
  <div>
    <h3>Comments</h3>
    <div v-for="comment in comments" :key="comment.id">
      <p>{{ comment.author }}: {{ comment.text }}</p>
      <p>{{ comment.timestamp }}</p>
    </div>
    <input v-model="newCommentText" placeholder="Write a comment" />
    <button @click="addComment">Add Comment</button>
  </div>
</template>

<script>
export default {
  name: "shopping-comment",
  props: {
    productId: String,
  },
  data() {
    return {
      comments: [],
      newCommentText: "",
    };
  },
  created() {
    // Fetch comments from the API
    fetch(`http://localhost:8080/api/comments/${this.productId}`)
        .then((response) => response.json())
        .then((data) => {
          this.comments = data;
        });
  },
  methods: {
    addComment() {
      // Add comment logic
      const newComment = {
        productId: this.productId,
        author: "User1", // Hardcoded for simplicity
        text: this.newCommentText,
        timestamp: new Date().toISOString(),
      };
      fetch("http://localhost:8080/api/comments", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newComment),
      })
          .then((response) => response.json())
          .then((comment) => {
            this.comments.push(comment);
            this.newCommentText = "";
          });
    },
  },
};
</script>

<style scoped>
/* 样式 */
</style>
