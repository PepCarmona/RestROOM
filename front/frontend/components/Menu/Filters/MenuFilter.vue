<template>
  <div class="menu-selector col">
    <button class="food-menu dropdown btn">
      {{ text }}
      <i class="fas fa-sort-down" />
    </button>
    <div class="food-menu dropdown">
      <div v-for="item in content" :key="item.id">
        {{ item.name }}
      </div>
    </div>
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
    },
    text: {
      type: String,
      default () {
        return ''
      }
    }
  }
}
</script>
<style scoped>
button.dropdown {
    background-color:  var(--light-orange);
    border: 1px solid var(--border-gray);
    text-align: left;
    padding-left: 20%;
    width: 100%;
    position: relative;
}
button.dropdown > i {
  position: absolute;
  right: 5%;
}
i.fa-sort-down {
    margin-top: .5%;
}
i.fa-sort-up {
    margin-top: 3%;
}
div.dropdown {
    display: none;
    position: absolute;
    width: 80%;
    overflow: auto;
    z-index: 1;
    background-color: var(--lightest-orange);
    margin-top: 4px;
    right: 12px;
    text-align: center;
}
div.dropdown > div {
    padding: 5px;
    cursor: pointer;
}
div.dropdown > div:hover {
    background-color: var(--light-orange);
}
</style>
