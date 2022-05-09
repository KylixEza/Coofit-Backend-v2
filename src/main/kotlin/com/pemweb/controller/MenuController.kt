package com.pemweb.controller

import com.oreyo.model.ingredient.IngredientBody
import com.oreyo.model.review.ReviewBody
import com.oreyo.model.step.StepBody
import com.pemweb.data.ICoofitRepository
import com.pemweb.helper.ResponseModelHelper.generalListSuccess
import com.pemweb.helper.ResponseModelHelper.generalSuccess
import com.pemweb.model.menu.MenuBody
import io.ktor.application.*

class MenuController(
	private val coofitRepository: ICoofitRepository
): IMenuController {
	
	override suspend fun ApplicationCall.addNewMenu(body: MenuBody) =
		this.generalSuccess("${body.title} successfully added") {
			coofitRepository.addNewMenu(body)
		}
	
	override suspend fun ApplicationCall.addNewIngredient(menuId: String, body: IngredientBody) =
		this.generalSuccess("${body.ingredient} successfully added") {
			coofitRepository.addNewIngredient(menuId, body)
		}
	
	override suspend fun ApplicationCall.addNewStep(menuId: String, body: StepBody) =
		this.generalSuccess("${body.step} successfully added") {
			coofitRepository.addNewStep(menuId, body)
		}
	
	override suspend fun ApplicationCall.addNewReview(menuId: String, body: ReviewBody) =
		this.generalSuccess("rating successfully added") {
			coofitRepository.addNewReview(menuId, body)
		}
	
	override suspend fun ApplicationCall.getSomeMenus() =
		this.generalListSuccess { coofitRepository.getSomeMenus() }
	
	override suspend fun ApplicationCall.getAllMenus() =
		this.generalListSuccess { coofitRepository.getAllMenus() }
	
	override suspend fun ApplicationCall.getMenuDetail(menuId: String) =
		this.generalSuccess { coofitRepository.getMenuDetail(menuId) }
	
	override suspend fun ApplicationCall.searchMenu(query: String) =
		this.generalListSuccess { coofitRepository.searchMenu(query) }
	
	override suspend fun ApplicationCall.getCaloriesPrediction(food: String) =
		this.generalSuccess { coofitRepository.getCaloriesPrediction(food) }
}