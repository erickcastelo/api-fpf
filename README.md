api-fpf
Tecnologias utilizadas no Back-End.
Spring Boot
Hibernate e JPA
Maven
Repositório para instalação das dependências do projeto.
Primeiro de tudo, você preciso ter o Java (na versão 8) e o maven instalado na sua máquina. Depois de instalado as suas variáveis de ambientes devem ser devidamente configuradas. Se você tem dúvida de como configurar as variáveis de ambiente, clique aqui para o java e aqui para o maven .

Configuração Banco.
O projeto necessita do MySQL instalado na versão, se possível, 5.7. Além disso o banco "avaliacao_fpf" deve ser criado.

As tabelas vão ser geradas automaticamente quando o servidor "levantar", então não se preocupe com isso.

Usuário e senha devem ser:

usuario: "root"
senha: ""
Instalar dependências
Primeiramente baixe o projeto do GitHub e navegue pelot terminal, ou prompt, até a pasta do projeto. Feito isso, e com o maven instalado e configurado, digite o seguinte comando:

mvn install
Com esse comando você vai instalar todas as dependêcias do projeto.

"Levantar" Servidor
Agora você precisa "levantar" o servidor da aplicação, mas antes, certifique se a porta 8080 não estar sendo usada. Essa é a porta padrão que vai ser usada na api. Certificando-se que a porta 8080 não estar sendo usada, digite o seguinte comando:

mvn spring-boot:run