<script setup>
import axios from 'axios';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';


let eou = useRouter();
// 用户信息对象
const vipuser = ref({
    account: '',
    password: '1234', // 如果密码是静态的，可以直接赋值；如果是用户输入，则应该使用 ref
    vipLv: '',
    vipBeginDate: formatDate(new Date()),
    vipTime: ''
});

// 会员等级选项
const Lv = [
    { value: 'Lv1', text: 'Lv1' },
    { value: 'Lv2', text: 'Lv2' },
    { value: 'Lv3', text: 'Lv3' }
];

// 会员时长选项
const ti = [
    { value: 'day', text: '一天' },
    { value: 'month', text: '一月' },
    { value: 'mo', text: '一季' },
    { value: 'year', text: '一年' }
];

// 绑定会员时长的选择
const vipTime1 = ref('');

// 格式化日期时间
function formatDate(date) {
    return [
        date.getFullYear() + '年',
        ('0' + (date.getMonth() + 1)).slice(-2) + '月',
        ('0' + date.getDate()).slice(-2) + '日 ',
        ('0' + date.getHours()).slice(-2) + ':',
        ('0' + date.getMinutes()).slice(-2) + ':',
        ('0' + date.getSeconds()).slice(-2)
    ].join('');
}

// 计算会员时长天数
const vipTimeDays = computed(() => {
    if (!vipTime1.value) return '';

    const timeMap = {
        '一月': 30 * (60 * 60 * 24),
        '一季': 90 * (60 * 60 * 24), // 假设每个季度为90天
        '一年': 365 * (60 * 60 * 24)
    };

    return timeMap[vipTime1.value] || '';
});
function add() {
    // 确保所有必填字段已赋值
    if (!vipuser.value.account || !vipuser.value.vipLv) {
        console.error('账户或会员等级未填写');
        return;
    }

    // 将 vipLv 转换为对应的整数值
    const lvMap = {
        'Lv1': 1,
        'Lv2': 2,
        'Lv3': 3
    };

    // 确保 vipLv 是有效的
    const selectedLv = lvMap[vipuser.value.vipLv];
    if (selectedLv === undefined) {
        console.error('无效的会员等级');
        return;
    }

    const i = {
        account: vipuser.value.account,
        password: vipuser.value.password, // 如果需要发送密码
        vipLv: selectedLv,
        vipBeginDate: formatDate(new Date()), // 确保日期格式正确
        vipTime: parseFloat(vipTimeDays.value) || 0, // 确保转换为数字
    };

    console.log("Sending data:", i); // 调试输出

    axios.post('http://localhost:8080/add', i, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(Response => {
            console.log(Response);
            eou.push('/biao')
        })
        .catch(error => {
            console.error("There was an error!", error.response ? error.response.data : error.message);
        });
}
</script>

<template>
    <div class="add">
        <h2>添加用户</h2>

        <span>账户名：</span><input type="text" v-model="vipuser.account" class="se"> <br>

        <div class="lv">
            <span>会员等级：</span>
            <select id="citySelectLv" name="vipLv" v-model="vipuser.vipLv" class="se">
                <option value="">请选择...</option>
                <option v-for="l in Lv" :key="l.value" :value="l.value">{{ l.text }}</option>
            </select><br>
        </div>


        <div class="time">
            <span>会员时长：</span>
            <select id="citySelectTime" name="vipTime" v-model="vipTime1" class="se">
                <option value="">请选择...</option>
                <option v-for="t in ti" :key="t.value" :value="t.text">{{ t.text }}</option>
            </select><br>
        </div>

        <input type="button" @click="add" value="添加" class="bu">
    </div>
</template>


<style scoped>
.add {
    background-color: #f0f8ff;
    width: 100%;
    height: 1500px;
    padding-left: 400px;
    padding-top: 100px;
}

.bu {
    background-color: #0074d9;
    width: 60px;
    height: 30px;
    margin-left: 20px;
    border: none;
    color: #fff;
    border-radius: 5px;
}

h2 {
    margin-left: 100px;
    margin-bottom: 39px;
}

.span {
    display: block;
    width: 50px;
}

.se {
    display: block;
    background-color: #ffffff;
    width: 300px;
    height: 30px;
    margin-top: 10px;
    outline: none;
    border: none;
}
</style>