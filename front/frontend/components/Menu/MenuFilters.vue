<template>
  <div class="row">
    <div class="menu-tab col-10 container">
      <div class="menu-filters row justify-content-around align-items-center">
        <menu-filter />
        <menu-filter />
        <menu-filter />
        <menu-filter />
      </div>
      <menu-categories />
    </div>
  </div>
</template>
<script>
import MenuFilter from '~/components/Menu/MenuFilter.vue'
import MenuCategories from '~/components/Menu/MenuCategories.vue'

export default {
  components: {
    MenuFilter,
    MenuCategories
  }
}
</script>
<style scoped>
.menu-filters {
    background-color: var(--transparent-white);
    padding-top: 15px;
}
.menu-filters > div {
    margin: 1px;
    padding-top: 5px;
    position: relative;
    display: inline-block;
}
</style>
