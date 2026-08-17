package com.joaovsq.banco.app;

import com.joaovsq.banco.services.MenuPrincipalService;

public class Main {

    static void main() {
        MenuPrincipalService menuPrincipalService = new MenuPrincipalService();
        menuPrincipalService.exibirMenuPrincipal();
    }
}
