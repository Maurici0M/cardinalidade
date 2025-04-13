<h1>Desafio API REST</h1>

Comandos GIT:

Caso uma branch seja criada localmente, e não esteja disponível no repositório remoto, é possível enviá-la utilizando o seguinte comando:

-> git push origin nome_branch_a_ser_enviada

Para verificar todas as branches remotas disponíveis, utilize o comando:

-> git branch -r

Para verificar todas as branches (locais e remotas), utilize o comando:

-> git branch -a

Para atualizar todas as branches do repositório local com as últimas alterações do repositório remoto, você pode usar o comando a seguir:

-> git fetch --all

Atualize as suas branches locais, uma por vez: Cada branch local precisa ser atualizada manualmente com o comando abaixo (enquanto você está dentro da branch local que deseja atualizar):

-> git pull origin nome-da-branch
