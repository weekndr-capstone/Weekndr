import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import singleView from './views/singleView'
import Itenerary from './views/Itenerary'
import TripHistory from './views/TripHistory'
import CurrentPastTrips from './views/CurrentPastTrips'
import Search from './views/Search'
import About from './views/About'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {title: 'Weekndr'}
    },
    {
      path: '/search',
      name: 'search',
      meta: {title: 'Search'},
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: Search
    },
    {
      path: '/single',
      name: 'single',
      component: singleView,
      props: true,
      meta: {title: 'Weekndr'}
    },
    {
      path: '/itenerary',
      name: 'itenerary',
      component: Itenerary,
      meta: {title: 'Itenerary'}
    },
    {
      path: '/triphistory',
      name: 'triphistory',
      component: TripHistory,
      meta: {title: 'TripHistory'}
    },
    {
      path: '/current',
      name: 'current',
      component: CurrentPastTrips,
      meta: {title: 'Current'}
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      meta: {title: 'About'}
    },
  ]
})
