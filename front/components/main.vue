<script setup>
import hea from './hea.vue'
import left from './left.vue'
import dob from './bod.vue'
</script>

<template>
    <div>

        <hea class="hea"></hea>
        <left></left>
        <!-- <dob class="hea"></dob> -->
         <div><router-view></router-view></div>
        
    </div>


</template>


<style scoped>
.hea{
    margin-left: 240px;
}
</style>