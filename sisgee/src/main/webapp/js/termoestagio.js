if(document.getElementById("valorRadio").value == "nao") {
	eagente("nao");
}else{
	eagente("sim");
} 

function eagente(tipo){
	if(tipo=="sim"){
		document.getElementById("exampleRadios1").checked = true;
		document.getElementById("agente1").style.display="block";
		document.getElementById("agente2").style.display="none";
		
		document.getElementById("cnpj_empresa").setAttribute("disabled","disabled");
		
		document.getElementById("cnpj_empresa_ligada").removeAttribute("disabled");
		document.getElementById("razao_social_empresa_ligada").removeAttribute("disabled");
		
	} else {
		document.getElementById("exampleRadios2").checked = true;
		document.getElementById("agente1").style.display="none";
		document.getElementById("agente2").style.display="inherit";
		
		document.getElementById("cnpj_empresa_ligada").setAttribute("disabled","disabled");
		
		document.getElementById("cnpj_empresa").removeAttribute("disabled");
		
	}
}
function buscarEmpresaLigada(){
	var form = document.getElementById('formulario');
	var cnpj = document.getElementById('cnpj_empresa_ligada').value;
	form.action='FrontControllerServlet?action=BuscarEmpresaLigada&cnpj_empresa_ligada='+cnpj;
	form.submit();
}
function buscarEmpresa(){
	var form = document.getElementById('formulario');
	var cnpj = document.getElementById('cnpj_empresa').value;
	form.action='FrontControllerServlet?action=BuscarEmpresa&cnpj_empresa='+cnpj;
	form.submit();
}
function buscarAluno(){
	var form = document.getElementById('formulario');
	var mat = document.getElementById('matricula').value;
	form.action='FrontControllerServlet?action=BuscarAluno&matricula='+mat;
	form.submit();
}
/*
if(document.getElementById("temProfessor").value == "s") {
	temProfessor('s');
}else{
	temProfessor('n');
}

function temProfessor(tipo){
	if(tipo == "s"){
		document.getElementById("temProfessor").checked = true;
	}else{
		document.getElementById("naoTemProfessor").checked = true;
	}
}*/


if(document.getElementById("valorprof").value == "n") {
	document.getElementById("naoTemProfessor").checked = true;
}else{
	document.getElementById("temProfessor").checked = true;
} 

