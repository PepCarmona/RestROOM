<template>
  <div :class="className" class="col">
    <button class="food-menu dropdown btn">
      {{ text }}
      <i class="fas fa-sort-down" />
    </button>
    <div class="food-menu dropdown">
      <div v-for="item in content" :key="item.id">
        <label>
          <input
            :id="item.id"
            type="checkbox"
            :name="text"
            :value="item.name"
            :checked="value.name == item.name"
            @input="$emit('input', item)"
          >
          {{ item.name }}
        </label>
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
    },
    value: {
      type: Array,
      default () {
        return []
      }
    }
  },
  computed: {
    className () {
      return this.text.toString().toLowerCase().replace(/\s/g, '') + '-selector'
    },
    capitalFilterOptions () {
      return this.content.map(function (item) {
        return item.name.charAt(0).toUpperCase() + item.name.slice(1)
      })
    }
  }
}
</script>
<style scoped>
button.dropdown {
    background-color:  var(--light-orange);
    border: 1px solid var(--border-gray);
    border-radius: 3px;
    text-align: left;
    padding-left: 20%;
    width: 100%;
    position: relative;
    box-shadow: 0 0 3px grey;
}
button.dropdown:hover {
    box-shadow: 0 0 3px 1px grey;
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
    box-shadow: 0 0 2px 1px grey inset;
}
div.dropdown > div > label {
    padding: 5px;
    cursor: pointer;
}
div.dropdown > div > label:hover {
    background-color: var(--light-orange);
    box-shadow: 0 0 2px 1px grey inset;
}
div.dropdown > div > label.active {
    background-color: var(--light-orange);
    box-shadow: 0 0 2px 1px grey inset;
}
</style>
