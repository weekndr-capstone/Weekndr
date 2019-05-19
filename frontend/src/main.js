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

var deferredPrompt;

window.addEventListener('beforeinstallprompt', function (e) {
    // Prevent Chrome 67 and earlier from automatically showing the prompt
    console.log("Working");
    e.preventDefault();
    // Stash the event so it can be triggered later.
    deferredPrompt = e;
    showAddToHomeScreen();
});

function showAddToHomeScreen() {
    var a2hsBtn = document.querySelector(".ad2hs-prompt");
    a2hsBtn.style.display = "block";
    a2hsBtn.addEventListener("click", addToHomeScreen);
}

function addToHomeScreen() {  var a2hsBtn = document.querySelector(".ad2hs-prompt");  // hide our user interface that shows our A2HS button
    a2hsBtn.style.display = 'none';  // Show the prompt
    deferredPrompt.prompt();  // Wait for the user to respond to the prompt
    deferredPrompt.userChoice
        .then(function(choiceResult){
            if (choiceResult.outcome === 'accepted') {
                console.log('User accepted the A2HS prompt');
            } else {
                console.log('User dismissed the A2HS prompt');
            }
            deferredPrompt = null;
        });}

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');


