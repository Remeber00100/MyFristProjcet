
<style scoped>

.left{
    position: fixed;
    left: 0;
    top: 0;
    height: 100%;
    width: 220px;
    background-color: #f0f8ff  ;
    display: flex;
    flex-direction: column;
}
.left a{
    display: block;
    width: 220px;
    height: 80px;
    background-color: #0074D9;
    color: white;
    text-align: center;
    line-height: 80px;
    font-size: 20px;
    margin-bottom: 10px;
}

.left .e{
    
    border-right: #ffffff solid 4px;
}

</style>
<template>
    <div class="left">
        <li><a href="index.html" class="index1" @click="io">首页</a></li>
        <li><a href="index.html" class="index2" @click="io2">表</a></li>
    </div>
</template>
<script setup>
import { useRouter } from 'vue-router'
const wae = useRouter()
function io2(event){
    event.preventDefault();
    
    wae.push("/bod")
}
function io(event){
    event.preventDefault();
    
    wae.push("/y")
}
</script>