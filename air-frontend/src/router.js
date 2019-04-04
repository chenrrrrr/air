import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "hash",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      redirect: "/allFlight"
    },
    {
      path: "/login",
      component: () => import("./views/login/index.vue")
    },
    {
      path: "/allFlight",
      component: () => import("./views/allFlight/index.vue")
    },
    {
      path: "/admin",
      component: () => import("./views/admin/index.vue"),
      children: [
        {
          path: "/admin/addFlight",
          component: () => import("./views/admin/addFlight.vue")
        },
        {
          path: "/admin/delUpdateFlight",
          component: () => import("./views/admin/delUpdateFlight.vue")
        },
        {
          path: "/admin/flightRouteConfig",
          component: () => import("./views/admin/flightRouteConfig.vue")
        },
        {
          path: "/admin/delUpdateUser",
          component: () => import("./views/admin/delUpdateUser.vue")
        }
      ]
    },
    {
      path: "/user",
      component: () => import("./views/user/index.vue"),
      children: [
        {
          path: "/user/flightView",
          component: () => import("./views/user/flightView.vue")
        },
        {
          path: "/user/myOrder",
          component: () => import("./views/user/myOrder.vue")
        },
        {
          path: "/user/addMsg",
          component: () => import("./views/user/addMsg.vue")
        },
        {
          path: "/user/viewMsg",
          component: () => import("./views/user/viewMsg.vue")
        }
      ]
    }
  ]
});
