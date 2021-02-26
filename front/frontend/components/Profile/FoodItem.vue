<template>
  <li>
    <div class="food-item">
      <strong>99.99 €</strong>
      <span>Food</span>
      <div class="icons">
        <span class="food-item-toggle fas fa-check-circle" />
        <span class="food-item-delete fas fa-trash-alt" />
      </div>
    </div>
    <div class="food-item-drop">
      <input type="text" name="food-name" value="Food">
      <div class="food-price">
        <input type="number" name="food-price" step="0.01" value="10">
        <span>€</span>
      </div>
      <textarea name="food-description">Description</textarea>
      <div class="filters">
        <div class="food-category">
          Categories
        </div>
        <div class="food-type">
          Food Type
        </div>
        <div class="food-allergens">
          Allergens
        </div>
      </div>
    </div>
  </li>
</template>
