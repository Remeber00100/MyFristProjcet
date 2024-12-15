<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const rou1 = useRouter();
let account = ref('')
let password = ref('')
const warning = ref(false);
const warning2 = ref(false);
function Inspection(String) {
    let regex = /^[a-zA-Z0-9]{6,20}$/;
    return regex.test(String);
}



// //检查账号密码
// function check() {
//     //判断账号密码格式
//     if (!Inspection(account.value) || !Inspection(password.value)) {
//         warning.value = true
//     } else if (!postFunction()) {
//         //判断账号密码是否正确：
//         warning2.value = true
//     }

// }



//发送请求方法，方法需要返回值，如果错误，要返回false，提示信息才能显示
function postFunction() {

        let code = 0
        axios.post('http://localhost:8080/login', null, {
            params: {
                AdminID: parseInt(account.value), // 替换为实际的管理员ID
                AdminPassWorld: password.value
            }
        }).then(function (Response) {
            console.log(Response.data.data);
            if(code == Response.data.code){
                rou1.push("/main")
            }else{
                warning2.value = true
            }
            
        })
        
    

}
</script>

<template>
    <div class="box">

        <div class="windows">
            <div class="left">

            </div>
            <div class="right">
                <h1> 欢迎登陆 </h1>
                <div class="from">
                    <span>用户名</span>
                    <input type="text" id="account" v-model="account">
                    <span>密码</span>
                    <input type="password" id="password" v-model="password">
                    <span class="warn" v-if="warning">账号密码格式错误</span>
                    <span class="warn" v-if="warning2">账号或密码错误</span>
                    <input type="button" value="登录" id="login" @click="postFunction">

                </div>
            </div>
        </div>

    </div>
</template>

<style scoped>
.box {
    width: 100%;
    height: 100vh;
    background-image: url(../img/70f27a3c52765658_big.jpg);
    background-position: center;
    background-repeat: no-repeat;
    background-size: 103%;
    color: #ffffff;
}

.windows {
    width: 40%;
    height: 50vh;
    background-color: #000000cd;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border-radius: 5%;
}

h1 {
    margin-top: 10vh;
    margin-bottom: 5%;
    text-align: center;
}

.from {
    color: #fff;
    display: flex;
    flex-direction: column;
    margin: 0 20% 0 20%;
    justify-content: space-around;
    height: 20vh;
}

.from input {
    outline: none;
    background: scroll;
    border: 0;
    border-bottom: #fff 0.2vh solid;
    color: #fff;
    height: 3vh;
    font-size: 2vh;
}

.warn {
    display: block;
    padding: 0.7vh;
    background-color: rgba(255, 64, 64, 0.279);
    border: #f56c6c solid 0.2vh;
    border-radius: 0.5vh;
    color: #f56c6c;
}

#login {
    margin-top: 0.6vh;
    background-color: #178bea;
    display: block;
    width: 15%;
    font-size: 1.7vh;
    border: 0;
    border-radius: 0.5vh;
}

#login:active {
    background-color: #1061a3;
}
</style>