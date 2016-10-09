(TeX-add-style-hook
 "raid"
 (lambda ()
   (TeX-add-to-alist 'LaTeX-provided-class-options
                     '(("article" "a4paper" "11pt")))
   (TeX-add-to-alist 'LaTeX-provided-package-options
                     '(("csquotes" "babel=true") ("adjustbox" "export")))
   (TeX-run-style-hooks
    "latex2e"
    "raid/partie"
    "article"
    "art11"
    "exptech"
    "textcomp"
    "graphicx"
    "array"
    "csquotes"
    "url"
    "hyperref"
    "wrapfig"
    "adjustbox"
    "titletoc"))
 :latex)

