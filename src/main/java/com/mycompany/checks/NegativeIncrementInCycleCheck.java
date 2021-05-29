package com.mycompany.checks;

import com.puppycrawl.tools.checkstyle.api.*;


public class NegativeIncrementInCycleCheck extends AbstractCheck{
    private boolean inFor;

    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR, TokenTypes.POST_DEC, TokenTypes.DEC, TokenTypes.MINUS_ASSIGN};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR, TokenTypes.POST_DEC, TokenTypes.DEC, TokenTypes.MINUS_ASSIGN};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[]{TokenTypes.FOR_ITERATOR, TokenTypes.POST_DEC, TokenTypes.DEC, TokenTypes.MINUS_ASSIGN};
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        if (ast.getType() == TokenTypes.FOR_ITERATOR) {
            this.inFor = true;
        }

        if (inFor) {
            if (ast.getType() == TokenTypes.POST_DEC) {
                String message = "Negative increment in cycle declaration found A.";
                log(ast.getLineNo(), message);
            }
            if (ast.getType() == TokenTypes.DEC) {
                String message = "Negative increment in cycle declaration found B.";
                log(ast.getLineNo(), message);
            }
            if (ast.getType() == TokenTypes.MINUS_ASSIGN) {
                String message = "Negative increment in cycle declaration found C.";
                log(ast.getLineNo(), message);
            }
        }
    }
    @Override
    public void leaveToken(DetailAST ast) {
        if (ast.getType() == TokenTypes.FOR_ITERATOR) {
            this.inFor = false;
        }
    }
}
