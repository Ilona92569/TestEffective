package com.example.testeffective.feature.ui.bottomsheets

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.testeffective.feature.R
import com.example.testeffective.feature.databinding.DialogChoiceCityBinding
import com.example.testeffective.feature.extensions.filterForCyrillic
import com.example.testeffective.feature.extensions.textChanges
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.checkbox.MaterialCheckBox
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.mapLatest

class ChoiceCityBottomSheets(
    private val context: Context,
    private val layoutInflater: LayoutInflater
) {

    private val menuDialog = BottomSheetDialog(context, R.style.BottomSheetMenuStyle)

    fun showMenuBottomSheet(
        cityFrom: String,
        viewLifecycleOwner: LifecycleOwner,
        goToBlankScreen: () -> Unit,
        goToNextFragment: (cityFrom: String, cityTo: String) -> Unit
    ) {
        val menuChoiceView = layoutInflater.inflate(R.layout.dialog_choice_city, null)

        val dialogBinding = DialogChoiceCityBinding.inflate(
            layoutInflater, menuChoiceView as ViewGroup, false
        )
        menuDialog.setContentView(dialogBinding.root)


        with(dialogBinding) {
            editTextCityFrom.setText(cityFrom)

            editTextCityFrom.filterForCyrillic()
            editTextCityTo.filterForCyrillic()

            iconClose.setOnClickListener { editTextCityTo.setText("") }
            buttonDifficultRoute.setOnClickListener {
                goToBlankScreen()
                menuDialog.behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            buttonWeekend.setOnClickListener {
                goToBlankScreen()
                menuDialog.behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            buttonHotTickets.setOnClickListener {
                goToBlankScreen()
                menuDialog.behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
            buttonAnywhere.setOnClickListener { editTextCityTo.setText(R.string.phuket) }

            itemFirst.textTitle.setText(R.string.istanbul)
            itemFirst.imageOffer.setImageResource(R.drawable.image_istanbul)
            itemSecond.textTitle.setText(R.string.sochi)
            itemSecond.imageOffer.setImageResource(R.drawable.image_sochi)
            itemThird.textTitle.setText(R.string.phuket)
            itemThird.imageOffer.setImageResource(R.drawable.image_phuket)

            itemFirst.root.setOnClickListener {
                editTextCityTo.setText(itemFirst.textTitle.text)
            }
            itemSecond.root.setOnClickListener {
                editTextCityTo.setText(itemSecond.textTitle.text)
            }
            itemThird.root.setOnClickListener {
                editTextCityTo.setText(itemThird.textTitle.text)
            }

            editTextCityTo
                .textChanges()
                .debounce(1000)
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .mapLatest { char ->
                    if (char.toString().isNotEmpty()) {
//                        Toast.makeText(context, char.toString(), Toast.LENGTH_SHORT).show()
                        goToNextFragment(editTextCityFrom.text.toString(), char.toString())
                        menuDialog.behavior.state = BottomSheetBehavior.STATE_HIDDEN
                    }
                }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
        menuDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        menuDialog.show()
    }
}