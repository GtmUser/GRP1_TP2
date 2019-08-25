<html>

<header>
<title>Authentification</title>
<link rel="stylesheet" href="authentification.css"/>
</header>

<body>
<!-- zone du logo -->
<div class="logo">
  <img src="images/logo.png" alt="logo" title="logo_Proxibanque">
  <span>ProxiBanque</span>
</div> 

<!-- fenetre identification -->
<div class="fenetre"><ath>
<form method="POST" name="auth" action='<%= response.encodeURL("j_security_check") %>' onsubmit="return verification();">
	<img src="images/user.png" alt="user_gif" title="user">
	<input type="text" name="j_username" id="id_user" placeholder="Identifiant"/>
	<br />
	<img src="images/cadenas.png" alt="cadenas_png" title="password">
	<input type="password" name="j_password" id="id_pwd" placeholder="Mot de passe"/>
	<br />
	<input type="submit" name="btm" id="id_btm" value="Connexion" title="connexion"/></form>
	<br />
	<mdp><button onClick="collapse()">Mot de passe oublier ?</button></mdp>
</ath></div>

<!-- Bandeau -->
<p id="id_about" style="display:none">GRP1 TP2<br />David et Alexandre </p>
<p id="id_contact" style="display:none">GT'M ingénierie<br />12 Villa de Lourcine, 75014 Paris</p>
<ul>
  <li style="float:right"><button type="button" onmouseenter="contact();" onmouseleave="nocontact();">Contact</button></li>
  <li style="float:right"><button type="button" onmouseenter="about();" onmouseleave="noabout();">About us</button></li>
</ul>

<!-- javascript -->
<script type="text/javascript" src="authentification.js" ></script>

</body>

</html>