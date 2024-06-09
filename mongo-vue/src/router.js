import Vue from "vue";
import Router from 'vue-router';
import Home from "./views/Home.vue";
import Product from "./views/Product.vue";
import Cart from "./components/Cart.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        { path: "/", name: "home", component: Home },
        { path: "/product/:id", name: "product", component: Product },
        { path: "/cart", name: "cart", component: Cart },
        { path: "/login", name: "login", component: Login },
        { path: "/register", name: "register", component: Register },
    ],
});
