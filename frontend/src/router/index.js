import Vue from 'vue';
import VueRouter from 'vue-router';
import BigFileUpload from '../components/BigFileUpload'
import StopUpload from '../components/StopUpload'
import QuickUpload from '../components/QuickUpload'
import SingleFileUpload from '../components/SingleFileUpload'

Vue.use(VueRouter);

const routes = [
  {path:'/singleFileUpload',component:SingleFileUpload},
  {path:'/bigFileUpload',component:BigFileUpload},
  {path:'/stopUpload',component:StopUpload},
  {path:'/quickUpload',component:QuickUpload},
  {path:'/',component:SingleFileUpload}
];

export default new VueRouter({
  routes
});
