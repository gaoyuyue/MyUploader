import Vue from 'vue'
import App from './App.vue'
import router from './router/index.js'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import global from './Global'
import VueResource from 'vue-resource'

Vue.prototype.global = global;

Vue.use(ElementUI);
Vue.use(VueResource);

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
