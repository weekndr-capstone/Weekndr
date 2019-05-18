import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import store from './store'
import '@fortawesome/fontawesome-free/css/all.css';

Vue.config.productionTip = false;
Vue.config.devtools = true;

const DEFAULT_TITLE = 'Weekndr';
router.afterEach((to, from) => {
    document.title = to.meta.title || DEFAULT_TITLE;
});

const prod = process.env.NODE_ENV === 'production';
const shouldSW = 'serviceWorker' in navigator && prod;
if (shouldSW) {
    navigator.serviceWorker.register('/service-worker.js').then(() => {
        console.log("Service Worker Registered!")
    })
}

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');


