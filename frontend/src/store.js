import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    location: '',
    dates: {start_date: '', end_date: ''},
  },

  getters:{
      location: state => {
          return state.location
      },
      dates: state => {
          return state.dates
      }
  },
  mutations: {
      changeLocation(state, location){
          state.location = location;
      },
      changeStartDate(state, start_date){
          state.dates.start_date = start_date;
      },
      changeEndDate(state, end_date){
          state.dates.end_date = end_date;
      },
      changeDates(state, dates){
          state.dates = dates;
      },
  },
  actions: {

  }
})
