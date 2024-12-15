<script setup>
import { useRouter } from 'vue-router';

const rou1 = useRouter();
window.onload=function (event){
    event.preventDefault()
    rou1.push("/biao")
}

function toAllList(event) {
    event.preventDefault()
    rou1.push("/biao")
}
function toAdd(event) {
    event.preventDefault()
    rou1.push("/add")
}
</script>

<template>
    <div class="bod">
        <div class="bodhead">
            <a href="#" class="bu" @click="toAllList">全部</a>
            <a href="#" class="bu" @click="toAdd">添加</a>

        </div>
        <router-view class="ee"></router-view>
    </div>
</template>

<style scoped>
.bod {
    margin-left: 240px;
    margin-top: 5px;
    display: flex;
    height: 100%;
    /* width: 100%; */
    background-color: aliceblue;
    flex-wrap: wrap;
}

.bodhead {
    display: flex;
    padding-left: 30px;
    height: 70px;
    width: 100%;
    background-color: aliceblue;
    padding-top: 10px;
}



.bu {
    display: block;
    color: #929bad;
    height: 50px;
    width: 80px;
    background-color: #cae6fc;
    text-align: center;
    line-height: 50px;
    margin-right: 15px;
    border: solid #8c8f94 1px;
    border-radius: 4px;
}
</style>