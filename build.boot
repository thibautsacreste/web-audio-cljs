(set-env!
  :source-paths #{"src/cljs"}
  :resource-paths #{"html"}

  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/clojurescript "1.8.51"]
                  [adzerk/boot-cljs "1.7.228-2"]
                  [pandeiro/boot-http "0.7.5"]
                  [adzerk/boot-reload "0.5.0"]
                  [adzerk/boot-cljs-repl "0.3.3"]
                  [com.cemerick/piggieback "0.2.1"]
                  [weasel "0.7.0"]
                  [org.clojure/tools.nrepl "0.2.12"]
                  [proto-repl "0.3.1"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(deftask dev
  "Launch Immediate Feedback Development Environment"
  []
  (comp
   (serve :dir "target")
   (watch)
   (reload)
   (cljs-repl)
   (cljs)
   (target :dir #{"target"})))
