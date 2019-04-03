import Vue from "vue";
import './plugins/axios'
import App from "./App.vue";
import '@/assets/less/common.less';
import router from "./router";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

// 鸡贼跳转
import '@/permission'

Vue.config.productionTip = false;
Vue.use(ElementUI);

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
