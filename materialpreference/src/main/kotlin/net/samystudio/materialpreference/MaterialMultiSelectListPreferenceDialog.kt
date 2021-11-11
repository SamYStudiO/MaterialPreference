package net.samystudio.materialpreference

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.preference.MultiSelectListPreferenceDialogFragmentCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MaterialMultiSelectListPreferenceDialog : MultiSelectListPreferenceDialogFragmentCompat() {
    private var onDialogClosedWasCalledFromOnDismiss = false
    // We use our own since super one is private.
    private var whichButtonClicked = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        whichButtonClicked = DialogInterface.BUTTON_NEGATIVE

        val builder = MaterialAlertDialogBuilder(requireContext())
            .setTitle(preference.dialogTitle)
            .setIcon(preference.dialogIcon)
            .setPositiveButton(preference.positiveButtonText, this)
            .setNegativeButton(preference.negativeButtonText, this)

        val contentView = onCreateDialogView(context)
        if (contentView != null) {
            onBindDialogView(contentView)
            builder.setView(contentView)
        } else {
            builder.setMessage(preference.dialogMessage)
        }

        onPrepareDialogBuilder(builder)

        return builder.create()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        whichButtonClicked = which
    }

    override fun onDismiss(dialog: DialogInterface) {
        onDialogClosedWasCalledFromOnDismiss = true
        super.onDismiss(dialog)
    }

    override fun onDialogClosed(positiveResult: Boolean) {
        if (onDialogClosedWasCalledFromOnDismiss) {
            onDialogClosedWasCalledFromOnDismiss = false
            // this means the positiveResult needs to be calculated from our mWhichButtonClicked
            super.onDialogClosed(whichButtonClicked == DialogInterface.BUTTON_POSITIVE)
        } else {
            super.onDialogClosed(positiveResult)
        }
    }

    companion object {
        fun newInstance(preferenceKey: String) =
            MaterialMultiSelectListPreferenceDialog().apply {
                arguments = Bundle().apply { putString(ARG_KEY, preferenceKey) }
            }
    }
}
