import Vue from 'vue';
import VueRouter from 'vue-router';
import FileUpload from '../components/FileUpload.vue'
import BigFileUpload from '../components/BigFileUpload.vue'
import StopUpload from '../components/StopUpload.vue'
import QuickUpload from '../components/QuickUpload.vue'

Vue.use(VueRouter);

const routes = [
  {path:'/fileUpload',component:FileUpload},
  {path:'/bigFileUpload',component:BigFileUpload},
  {path:'/stopUpload',component:StopUpload},
  {path:'/quickUpload',component:QuickUpload},
  {path:'/',component:FileUpload}
];

export default new VueRouter({
  routes
});
