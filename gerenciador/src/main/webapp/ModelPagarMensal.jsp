<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGAR MENSAL</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
</style>
</head>

		
<body>
 <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>CONTINENTAL BANK</h2>
      </div>

      <div class="row">      
        <div class="py-5 text-center">
          <h4 class="mb-3">PAGAR MENSAL</h4>
          <form method="post" action="pagarMensal">
            <div class="row col-md-12">
	             <div class="col-md-6 mb-3">
	               <label for="firstName">Número da conta:</label>
	               <input type="text" class="form-control" name="numConta" id="numConta" placeholder="Número da conta" required>
	               <div class="invalid-feedback">
	                 Número da conta é obrigatorio.
	               </div>
	             </div>

			</div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Pagar Mensalidade</button>
          </form>
        </div>
      </div>
      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2023 : Continental Bank</p>
      </footer>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>