package com.mycompany.checks;

import com.puppycrawl.tools.checkstyle.api.*;


public class NegativeIncrementInCycleCheck extends AbstractCheck{
    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR};
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        if(ast.branchContains(TokenTypes.POST_DEC) || ast.branchContains(TokenTypes.DEC) || ast.branchContains(TokenTypes.MINUS_ASSIGN)){
            String message = "Negative increment in cycle declaration found.";
            log(ast.getLineNo(), message);
        }
    }

}
