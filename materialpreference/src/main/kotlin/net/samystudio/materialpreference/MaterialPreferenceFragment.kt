package net.samystudio.materialpreference

import androidx.fragment.app.DialogFragment
import androidx.preference.*

abstract class MaterialPreferenceFragment : PreferenceFragmentCompat() {
    override fun onDisplayPreferenceDialog(preference: Preference) {
        if ((activity as? OnPreferenceDisplayDialogCallback)?.onPreferenceDisplayDialog(
                this,
                preference
            ) == true
        ) return

        // check if dialog is already showing.
        if (parentFragmentManager.findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") != null)
            return

        val f: DialogFragment = when (preference) {
            is EditTextPreference ->
                MaterialEditTextPreferenceDialog.newInstance(preference.getKey())
            is ListPreference ->
                MaterialListPreferenceDialog.newInstance(preference.getKey())
            is MultiSelectListPreference ->
                MaterialMultiSelectListPreferenceDialog.newInstance(preference.getKey())
            else -> throw IllegalArgumentException(
                "Cannot display dialog for an unknown Preference type: " +
                        preference::class.java.simpleName +
                        ". Make sure to implement onPreferenceDisplayDialog() to handle " +
                        "displaying a custom dialog for this Preference."
            )
        }

        f.setTargetFragment(this, 0)
        f.show(parentFragmentManager, "androidx.preference.PreferenceFragment.DIALOG")
    }
}