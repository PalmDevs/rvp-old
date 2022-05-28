package app.revanced.extensions

import app.revanced.patcher.util.smali.toInstruction
import org.jf.dexlib2.builder.MutableMethodImplementation

internal fun MutableMethodImplementation.injectHideCall(
    index: Int,
    register: Int
) {
    this.addInstruction(
        index,
        "invoke-static { v$register }, Lfi/razerman/youtube/XAdRemover;->HideView(Landroid/view/View;)V".toInstruction()
    )
}

internal fun String.startsWithAny(vararg prefix: String): Boolean {
    for (_prefix in prefix)
        if (this.startsWith(_prefix))
            return true

    return false
}

internal fun String.containsAny(vararg others: String): Boolean {
    for (other in others)
        if (this.contains(other))
            return true

    return false
}