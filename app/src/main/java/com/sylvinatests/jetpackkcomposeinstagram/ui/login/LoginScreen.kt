package com.sylvinatests.jetpackkcomposeinstagram.ui.login

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylvinatests.jetpackkcomposeinstagram.R

@Preview(showBackground = true, showSystemUi = true)
@Composable()
fun PreviewScreen() {
    LoginScreen(PaddingValues(0.dp))
}

@Composable
fun LoginScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(8.dp)
    ) {
        MyHeader(Modifier.align(Alignment.TopEnd))
        BodyScreen(Modifier.align(Alignment.Center))
        FooterScreen(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun MyHeader(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        modifier = modifier.clickable { activity.finish() },
        imageVector = Icons.Default.Close,
        contentDescription = "Close app"
    )
}

@Composable
fun BodyScreen(modifier: Modifier) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var isLoginEnabled by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) {
            email = it
            isLoginEnabled = enableLogin(email = email, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {
            password = it
            isLoginEnabled = enableLogin(email = email, password = password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        ButtonLogin(isLoginEnabled)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.insta_logo),
        contentDescription = "Instagram Logo"
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { onTextChanged(it) },
        placeholder = { Text(text = "Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFB2B2B2),
            focusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {

    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { onTextChanged(it) },
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFB2B2B2),
            focusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image =
                if (passwordVisible) R.drawable.ic_hide_password else R.drawable.ic_show_password
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "Password Visibility"
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9)
    )
}

@Composable
fun ButtonLogin(isLoginEnable: Boolean) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
        enabled = isLoginEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EABE9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log in")
    }
}

fun enableLogin(email: String, password: String): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6


@Composable
fun LoginDivider() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            modifier = Modifier.padding(horizontal = 18.dp),
            text = "OR",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.fb_logo),
            contentDescription = "Social Login FB"
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Continue as Sylvie",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FooterScreen(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Don't have an account", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Sign Up",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}



