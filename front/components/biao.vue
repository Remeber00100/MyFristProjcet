<script setup>
import axios from 'axios';
import { onMounted, reactive } from 'vue';
import { useRouter } from 'vue-router';

const state = reactive({
    vipUsers: []
});

const ro = useRouter()

function hi() {
    axios.post('http://localhost:8080/findAll')
        .then(response => {
            state.users = response.data.data.map(vipUsers => ({
                id: vipUsers.id,
                account: vipUsers.account,
                password: vipUsers.password,
                vipLv: vipUsers.vipLv,
                vipBeginDate: vipUsers.vipBeginDate,
                vipTime: vipUsers.vipTime/(60*60*24)
            }));
        })
}

onMounted(hi);

function deleteUser(id) {
    axios.delete('http://localhost:8080/delete', {
        params: {
            id: id
        }
    })
        .then(response => {
            console.log(response.data)
            hi()
        })
}

function editUser(id) {
    ro.push({
        name: 'editUser',
        params: { adminId: id }
    })
}

</script>



<template>
    <div class="dd">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>会员等级</th>
                    <th>开始时间</th>
                    <th>会员时长</th>
                    <th>管理</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in state.users" :key="user.id">
                    <td>{{ user.id }}</td>
                    <td>{{ user.account }}</td>
                    <td>{{ user.password }}</td>
                    <td>{{ user.vipLv }}</td>
                    <td>{{ user.vipBeginDate }}</td>
                    <td>{{ user.vipTime }}</td>
                    <td>
                        <input type="button" class="delet bu" value="删除" @click="deleteUser(user.id)">
                    </td>
                </tr>
            </tbody>

        </table>






    </div>
</template>
<style scoped>
.bu {
    background-color: #0074d9;
    width: 60px;
    height: 30px;
    margin-left: 20px;
    border: none;
    color: #fff;
    border-radius: 5px;
}

.dd {
    margin-top: 50px;
    /* background-color: #647a8b; */
    width: 100%;
    padding: 20px;
    padding-bottom: 200px;
    border-radius: 40px;
    margin: 0 auto;

}

table {
    border-collapse: collapse;
    margin-top: 10px;
}

table,
thead {
    width: 100%;
}

table,
th,
td {
    background-color: aliceblue;
    border-right: 1px solid rgba(176, 163, 163, 0.511);
    padding: 6px;
    height: 45px;
}
</style>