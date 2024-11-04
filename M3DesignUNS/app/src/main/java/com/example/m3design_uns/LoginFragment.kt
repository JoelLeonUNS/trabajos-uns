package com.example.m3design_uns

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailField = view.findViewById<TextInputEditText>(R.id.etEmail)
        val passwordField = view.findViewById<TextInputEditText>(R.id.etPassword)
        val loginButton = view.findViewById<MaterialButton>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (validateForm(email, password)) {
                // Handle login logic here
                Toast.makeText(requireContext(), "Iniciando sesión...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateForm(email: String, password: String): Boolean {
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Mostrar error en el campo de correo
            return false
        }
        if (password.isEmpty() || password.length < 6) {
            // Mostrar error en el campo de contraseña
            return false
        }
        return true
    }
}
