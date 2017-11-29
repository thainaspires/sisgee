-- DROP NAS TABELAS ATUAIS

delete from pessoa;
delete from aluno;
delete from termoestagio;
delete from termoaditivo; 
delete from convenio;
delete from curso;
delete from empresa;
delete from professororientador;
delete from campus;
delete from agenteintegracao;

--	NOME DOS PROFESSORES
insert into ProfessorOrientador values (1, 'SILVIA JOSEFINA LERARIO RAMOS');  
insert into ProfessorOrientador values (2, 'FRANCISCA MARIA CARDAMONE LERARI');  
insert into ProfessorOrientador values (3, 'SANDRA LERARIO RAMOS');  
insert into ProfessorOrientador values (4, 'GUILHERME LERARIO RAMOS');  
insert into ProfessorOrientador values (5, 'GILVAN SILVA DE OLIVEIRA');  
insert into ProfessorOrientador values (6, 'JULIO CESAR TOLEDO PIZA JUNIOR');  
insert into ProfessorOrientador values (7, 'EDUARDO NATALE PACIULLI');  
insert into ProfessorOrientador values (8, 'FRANCISCO MESQUITA NETO');  
insert into ProfessorOrientador values (9, 'PIEDADE ELVIRA CATARINACHO');  
insert into ProfessorOrientador values (10, 'MARCELO MAIA DE AZEVEDO CORREA');  
insert into ProfessorOrientador values (11, 'ALOYSIO DE ANDRADE FARIA');

-- AGENTES DE INTEGRAÇÃO                                                                                                                              
insert into AgenteIntegracao values (1,  36543427113604, 'AUGUSTO JOAO GIL');           
insert into AgenteIntegracao values (2,  75740307137567, 'TULLIO PRADA');               
insert into AgenteIntegracao values (3,  90562296778339, 'ELIO CEPOLLINA');         
insert into AgenteIntegracao values (4,  95165470511892, 'MARIA CARLOTTA');         
insert into AgenteIntegracao values (5,  76463266014114, 'HELIO PENTAGNA GUIMARAES');         
insert into AgenteIntegracao values (6,  46733051502603, 'MUSSI ZAUITH');         
insert into AgenteIntegracao values (7,  53574401563098, 'HENRIQUE KRACOCHANSKY');         
insert into AgenteIntegracao values (8,  40173501611303, 'BENY MARIA VERDI HADDAD');         
insert into AgenteIntegracao values (9,  81449348838235, 'ROSY LAVINIA ROQUETTE VERDI');         
insert into AgenteIntegracao values (10, 50978351525160, 'JOAO BATISTELA BIAZON'); 

--	EMPRESAS COM OU SEM AGENTE DE INTEGRAÇÃO
insert into Empresa  values (1,  43317270368123, 'SUZANO PAPEL E CELULOSE SA', 1);
insert into Empresa  values (2,  88068866509228, 'GRADIENTE ELETRONICA S/A', 2);
insert into Empresa  values (3,  39172430941687, 'FORD MOTOR COMPANY BRASIL LTDA', 3);
insert into Empresa  values (4,  55349130116787, 'VALE FERTILIZANTES SA', 4);
insert into Empresa  values (5,  96308231739124, 'BOLSA DE VALORES DE SAO PAULO', 5);
insert into Empresa  values (6,  24440228390279, 'CONSTRUTORA OAS LTDA', 6);
insert into Empresa  values (7,  03698972868493, 'ENGERAL SA', 7);
insert into Empresa  values (8,  94796594586781, 'DAMOVO DO BRASIL SA', 8);
insert into Empresa  values (9,  50937036294078, 'GLOBEX ADM DE CONSORCIOS LTDA', 9);
insert into Empresa  values (10, 73991064341721, 'RODOBENS A E C DE SEGUROS S C LT', 10);
insert into Empresa  values (11, 68289895222506, 'CONDOMINIO PALAZZO RAVENNA', null);
insert into Empresa  values (12, 70230198082962, 'MUNIR ABBUD EMPREENDIMENTOS IMOBILIARIO', null);
insert into Empresa  values (13, 34354671415441, 'JAMARI ADMINISTRADORA DE CONSORCIOS S/C', null);
insert into Empresa  values (14, 84235609877558, 'GE WATER & PROCESS TECHNOLOGIES DO BRAS', null);
insert into Empresa  values (15, 61045321239122, 'AUTO VIACAO URUBUPUNGA LTDA', null);
insert into Empresa  values (16, 91647215260065, 'ENSIN EMPRESA NACIONAL S. E. LTDA', null);
insert into Empresa  values (17, 79117110444874, 'IBF INDUSTRIA BRASILEIRA DE FILMES SA',null);
insert into Empresa  values (18, 44334044184046, 'FINASA ZURICH P RV30 FIF FIN INV MERCSP',null);
insert into Empresa  values (19, 37851243074558, 'KONA FIF',null);
insert into Empresa  values (20, 30140532623433, 'COINVALORES CCVM LTDA',null);
insert into Empresa  values (21, 32599796770751, 'BRADESCO FUNDO DE INVEST FINAN ACORIANO',null);
insert into Empresa  values (22, 21656231704119, 'FINASA RF EXCLUSIVO FC FIF MERCSP MERCS',null);
insert into Empresa  values (23, 84302913962910, 'DESENBAHIA FUNDESE GIRO',null);  

-- CONVENIO
insert into Convenio  values (1,  6721005388, 1);
insert into Convenio  values (2,  6370547536, 21);
insert into Convenio  values (3,  8543730878, 22);
insert into Convenio  values (4,  5784156115, 3);
insert into Convenio  values (5,  7939585726, 7);
insert into Convenio  values (6,  3749484989, 4);
insert into Convenio  values (7,  0815186283, 14);
insert into Convenio  values (8,  0819257114, 8);
insert into Convenio  values (9,  7018131827, 14);
insert into Convenio  values (10, 9131773954, 12);
insert into Convenio  values (11, 6962246274, 15);
insert into Convenio  values (12, 8637535725, 3);
insert into Convenio  values (13, 6204216593, 15);
insert into Convenio  values (14, 5365797456, 15);
insert into Convenio  values (15, 7714197465, 4);
insert into Convenio  values (16, 9191226129, 9);
insert into Convenio  values (17, 2692200562, 7);
insert into Convenio  values (18, 1205456057, 12);
insert into Convenio  values (19, 4998663708, 10);

-- CAMPUS
insert into Campus values (1, 'Maracanã');
insert into Campus values (2, 'Angra dos Reis');
insert into Campus values (3, 'Itaguaí');
insert into Campus values (4, 'Maria da Graça');
insert into Campus values (5, 'Nova Friburgo');
insert into Campus values (6, 'Nova Iguaçu');
insert into Campus values (7, 'Petrópolis');
insert into Campus values (8, 'Valença');

-- CURSO
insert into Curso  values (1,  'Bacharelado em Engenharia Civil', 'Bacharelado em Engenharia Civil', 1);
insert into Curso  values (2,  'Bacharelado em Engenharia Ambiental', 'Bacharelado em Engenharia Ambiental', 2);
insert into Curso  values (3,  'Bacharelado em Engenharia da Computação', 'Bacharelado em Engenharia da Computação', 3);
insert into Curso  values (4,  'Bacharelado em Administração', 'Bacharelado em Administração', 4);
insert into Curso  values (5,  'Bacharelado em Engenharia de Controle e Automação', 'Bacharelado em Engenharia de Controle e Automação Industrial', 5);
insert into Curso  values (6,  'Bacharelado em Engenharia Produção', 'Bacharelado em Engenharia Produção', 6);
insert into Curso  values (7,  'Bacharelado em Engenharia de Telecomunições', 'Bacharelado em Engenharia de Telecomunições', 7);
insert into Curso  values (8,  'Bacharelado em Engenharia Elétrica', 'Bacharelado em Engenharia Elétrica', 8);
insert into Curso  values (9,  'Bacharelado em Engenharia Mecânica', 'Bacharelado em Engenharia Mecânica', 1);
insert into Curso  values (10, 'Bacharelado Sistemas de informação', 'Bacharelado Sistemas de informação', 3);
insert into Curso  values (11, 'Licenciatura em Física', 'Licenciatura em Física', 5);

-- PESSOA
insert into Pessoa  values (1, 'HUMBERTO SANTANA ');
insert into Pessoa  values (2, 'OTTO WALTER FRIEDRICH KNEUBUHLER');
insert into Pessoa  values (3, 'ANTONIO CARLOS BARROS FORMIGA');
insert into Pessoa  values (4, 'MARIA LOURDES');
insert into Pessoa  values (5, 'EDGAR SILVEIRA');

--	ALUNOS
insert into Aluno  values (1, '1411021ENG', 1, 1);
insert into Aluno  values (2, '1412035ENG', 2, 2);
insert into Aluno  values (3, '1431627ENG', 3, 3);
insert into Aluno  values (4, '1491321ENG', 4, 4);
insert into Aluno  values (5, '1123456ENG', 5, 5);

--	TERMO ESTAGIO
insert into TermoEstagio (idte, datainiciote, datafimte, datarescisaote, cargahorariate, valorbolsa, enderecote, numeroEnderecote, complementoEnderecote, bairroEnderecote, cepEnderecote, cidadeEnderecote, estadoEnderecote, EstagioObrigatorio, professororientador_idprofessororientador, aluno_idaluno, convenio_idconvenio) values (1, '2016-07-07', '2016-12-08', '2016-12-09', 6, 500.00, 'Endereco Termo Estagio', '206', 'complementoEnderecoTermoEstagio', 'bairroEnderecoTermoEstagio', '21321312', 'cidadeEnderecoTermoEstagio', 'RJ', 1, 1, 1, 1);
insert into TermoEstagio (idte, datainiciote, datafimte, datarescisaote, cargahorariate, valorbolsa, enderecote, numeroEnderecote, complementoEnderecote, bairroEnderecote, cepEnderecote, cidadeEnderecote, estadoEnderecote, EstagioObrigatorio, professororientador_idprofessororientador, aluno_idaluno, convenio_idconvenio) values (2, '2016-07-07', '2016-12-08', '2016-12-09', 'Rescindido', 5, 800.00, 'Endereco Termo Estagio', '206', 'complementoEnderecoTermoEstagio', 'bairroEnderecoTermoEstagio', '21321312', 'cidadeEnderecoTermoEstagio', 'RJ', 2, 2, 2, 2);
insert into TermoEstagio (idte, datainiciote, datafimte, datarescisaote, cargahorariate, valorbolsa, enderecote, numeroEnderecote, complementoEnderecote, bairroEnderecote, cepEnderecote, cidadeEnderecote, estadoEnderecote, EstagioObrigatorio, professororientador_idprofessororientador, aluno_idaluno, convenio_idconvenio) values (3, '2016-07-07', '2016-12-08', '2016-12-09', 'Rescindido', 5, 900.00, 'Endereco Termo Estagio', '206', 'complementoEnderecoTermoEstagio', 'bairroEnderecoTermoEstagio', '21321312', 'cidadeEnderecoTermoEstagio', 'RJ', 3, 3, 3, 3);

--	TERMO ADITIVO
insert into TermoAditivo (idta, datafimta, cargahorariata, valorbolsata, enderecota, numeroEnderecota, complementoEnderecota, bairroEnderecota, cepEnderecota, cidadeEnderecota, estadoEnderecota, idte) values (1, '2016-12-30', 6, 900.00, 'Endereco Termo Estagio', '206', 'complementoEnderecoTermoEstagio', 'bairroEnderecoTermoEstagio', '21321312', 'cidadeEnderecoTermoEstagio', 'RJ', 2);
insert into TermoAditivo (idta, datafimta, cargahorariata, valorbolsata, enderecota, numeroEnderecota, complementoEnderecota, bairroEnderecota, cepEnderecota, cidadeEnderecota, estadoEnderecota, idte) values (2, '2016-12-30', 6, 900.00, 'Endereco Termo Estagio', '206', 'complementoEnderecoTermoEstagio', 'bairroEnderecoTermoEstagio', '21321312', 'cidadeEnderecoTermoEstagio', 'RJ', 3);
