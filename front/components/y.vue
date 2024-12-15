<script setup>
import axios from 'axios';
import { onMounted } from 'vue';
import { ref } from 'vue';

let allVipMounts = ref('')
function allVipMount() {
    axios('http://localhost:8080/allVipMount')
        .then(Response => {
            allVipMounts.value = Response.data.data
        })
}
onMounted(allVipMount);
</script>
<template>
    <div class="y">
        <div class="mass">
            <div class="mount">
                <span class="fri o">
                    当前会员人数：
                </span>
                <span class="sec o">
                    {{ allVipMounts }}
                </span>
            </div>
        </div>

    </div>
</template>
<style scoped>
.y {
    margin-left: 240px;
    background-color: #ffffff;
    display: flex;
    position: relative;
    padding-bottom: 120px;
}

.img {
    width: 800px;
    left: 50%;
    transform: translateX(-50%);
    position: absolute;
    margin-top: 40px;
    border-radius: 30px;
}

.mass {
    margin-top: 500px;
    margin-left: 300px;
}
.mount{
    background-color: rgb(129, 217, 249);
    width: 300px;
    height: 80px;
    display: flex;
    flex-wrap: wrap;
    padding: 10px;
    border-radius: 8px;
}
.o{
    display: block;
    width: 100%;
}
</style>