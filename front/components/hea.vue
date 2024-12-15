<script setup>
import { useRouter } from 'vue-router';
const rou1 = useRouter();
function toLogin(event) {
  event.preventDefault();
  rou1.push("/login")
}
</script>

<template>
  <div class="header">
    <h2>影视会员管理系统</h2>
    <div class="userhead">
      <span>已登陆</span><a href="#" class="loginButton" @click="toLogin">退出登录</a>
    </div>

  </div>
</template>

<style scoped>

span{
  color: #fff;
  margin-right: 15px;
}
.header {
  height: 60px;
  background-color: #0074D9;
  display: flex;
}
h2 {
  line-height: 60px;
  margin-left: 80px;
  flex: 0.8;
  color: #ffffff;
}

.loginButton {
  color:#000000;
  margin-left:auto;
  line-height: 60px;
  /* flex: 1; */
}
</style>