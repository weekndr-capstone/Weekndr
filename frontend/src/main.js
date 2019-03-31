import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import '@fortawesome/fontawesome-free/css/all.css';
import {AxiosInstance as axios} from "axios";

Vue.config.productionTip = false;
Vue.config.devtools = true;

const DEFAULT_TITLE = 'Weekndr';
router.afterEach((to, from) => {
    document.title = to.meta.title || DEFAULT_TITLE;
});

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');


