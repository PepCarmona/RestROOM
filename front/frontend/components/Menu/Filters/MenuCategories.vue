<template>
  <div class="menu-categories scrollable-tabs row justify-content-center align-items-center">
    <ul>
      <li v-for="item in content" :key="item.id">
        {{ item.name }}
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  props: {
    content: {
      type: Array,
      default () {
        return []
      }
    }
  }
}
</script>
<style scoped>
.scrollable-tabs {
    padding-top: 3vh;
    background-color: var(--transparent-white);
}
.scrollable-tabs ul {
    list-style-type: none;
    background-color: var(--transparent-white);
    display: flex;
    overflow: auto;
    white-space: nowrap;
}
.scrollable-tabs li {
    display: inline-block;
    height: 50px;
    min-width: 100px;
    text-align: center;
    padding: 10px 25px 10px 25px;
    margin: 0 10px 0 10px;
    line-height: 50px;
    white-space: normal;
}
.scrollable-tabs li:hover {
    cursor: pointer;
    background-color: rgba(196, 127, 0, 0.253);
}
</style>
