import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import singleView from './views/singleView'
import Itenerary from './views/Itenerary'
import TripHistory from './views/TripHistory'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/search',
      name: 'search',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/Search.vue')
    },
    {
      path: '/single',
      name: 'single',
      component: singleView,
    },
    {
      path: '/itenerary/:id',
      name: 'itenerary',
      component: Itenerary
    },
    {
      path: '/triphistory/:id',
      name: 'triphistory',
      component: TripHistory
    }
  ]
})
