
<html><head><title>Login Page</title></head><body onload='document.f.email.focus();'>
<h3>Login with Username and Password</h3><form name='f' action='/login' method='POST'>
	<table>
		<tr><td>User:</td><td><input type='text' name='email' value=''></td></tr>
		<tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
		<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
	</table>
</form></body></html>