<template>
  <div class="menu-selector col">
    <button class="food-menu dropdown btn">
      Menu
      <i class="fas fa-sort-down" />
    </button>
    <div class="food-menu dropdown">
      <div data-id="1">
        menu 1
      </div>
      <div data-id="2">
        menu 2
      </div>
      <div data-id="3">
        menu 3
      </div>
    </div>
  </div>
</template>
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
