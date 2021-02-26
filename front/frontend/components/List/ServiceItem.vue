<template>
  <div class="ccard" :class="{ active: isSelected(service.id) }">
    <label> {{ service.name }}
      <input :id="service.id" type="checkbox" :value="service.name" @input="$emit('input', service)">
    </label>
    <i class="fa fa-check" :class="isSelected(service.id) ? 'checked' : 'unchecked'" />
  </div>
</template>
<script>
export default {
  props: {
    service: {
      type: Object,
      default () {
        return {}
      }
    },
    pickedServices: {
      type: Array,
      default () {
        return []
      }
    }
  },
  methods: {
    isSelected (id) {
      let found = false
      this.$props.pickedServices.forEach((element) => {
        if (element.id === id) {
          found = true
        }
      })
      return found
    }
  }
}
</script>
<style scoped>
.check-services div {
    display: flex;
    justify-content: space-between;
    align-items: center;
    cursor: pointer;
    height: 35px;
    background-color: rgba(255, 255, 255, 0.322);
    color: rgb(80, 80, 80);
    margin-bottom: 8px;
}
.check-services div:hover {
    color: black;
}
.check-services div.active {
  background-color: rgb(194, 194, 194);
}
.check-services div p {
    margin-bottom: 0;
}
.check-services div * {
    cursor: pointer;
}
.check-services div i.unchecked {
    color: rgba(0, 0, 0, 0.125);
}
.check-services div:hover i.unchecked {
    color: rgba(0, 0, 0, 0.25);
}
.check-services div i.checked {
    color: rgb(100, 160, 11)
}
.check-services div:hover i.checked {
    color: rgb(113, 179, 15)
}
.check-services div label {
  height: 100%;
  line-height: 34px;
  width: 100%;
}
.check-services div input {
  display: none;
}
</style>
