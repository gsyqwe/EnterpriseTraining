import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/Index'
import Movie from '../components/Movie'
import Music from '../components/Music'
import Detail from '../components/Detail'
import MusicList from '../components/MusicList'
import Add from '../components/Add'
import Update from '../components/Update'

Vue.use(Router)
export default new Router({
    routes: [
        {
            path: '/',
            component: Index
        },
        {
            path: '/movie',
            component: Movie
        },
        {
            path: '/music',
            component: Music
        },
        {
            path: '/detail/:id',
            component: Detail
        },
        {
            path: '/rank/:id',
            component: MusicList
        },
        {
            path: '/add',
            component: Add
        },
        {
            path: '/update/:id',
            component: Update
        },
    ]
})