import { createRouter, createWebHashHistory } from 'vue-router'

import main from "../components/main.vue"
import biao from "../components/biao.vue"
import add from "../components/add.vue"
import login from "../components/login.vue"
import y from "../components/y.vue"
import bod from "../components/bod.vue"

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/",
            component: login,

        },
        {
            path: "/login",
            component: login,

        },
        {
            path: "/main",
            component: main,
            children: [
                {
                    path: '/y',
                    component: y
                },
                {
                    path: '',
                    component: y
                },
                {
                    path:'/bod',
                    component: bod,
                    children:[
                        {
                            path: '',
                            component: biao
                        },
                        {
                            path: '/biao',
                            component: biao
                        },
                        {
                            path: '/add',
                            component: add
                        }
                    ]
                }
            ]
        }
    ]
})

export default router