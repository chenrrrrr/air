import router from "./router";
import { TabPane } from "element-ui";

// 登录
router.beforeEach((to, from, next) => {
  console.log(to.path);
  if (localStorage.getItem("flag") === null) {
    if (to.path === "/" || to.path === "/login" || to.path === "/allFlight") {
      next();
    } else {
      next({
        path: "/"
      });
    }
  } else {
    if (
      localStorage.getItem("flag") === "user" &&
      !to.path.startsWith("/user")
    ) {
      next({
        path: "/user"
      });
    } else if (
      localStorage.getItem("flag") === "admin" &&
      !to.path.startsWith("/admin")
    ) {
      next({
        path: "/admin"
      });
    } else {
      next();
    }
  }
});
